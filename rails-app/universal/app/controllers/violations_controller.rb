class ViolationsController < ApplicationController
  before_action :set_violation, only: [:show, :edit, :update, :destroy]
  skip_before_filter :verify_authenticity_token, only: [:districts, :neighborhoods, :type]
  before_action :find_all_tag_list, only: [:new, :edit, :index]
  before_action :authenticate_user!, only: [:edit, :new, :create, :update, :comment]
  before_action :check_user_authentication, only: [:edit, :update]

  # GET /violations
  # GET /violations.json
  def index
    @q = Violation.ransack(params[:q])
    @violations = @q.result.includes(:city, :district, :neighborhood)
    @violations = @violations.tagged_with(params[:tag_list]) if params[:tag_list].present?
    if (!params[:sort_type].nil? && params[:sort_type] == "created_at")
        @violations = @violations.sort_by do |v|
          v.created_at
        end
        @violations = @violations.reverse
    else
        @violations = @violations.sort_by do |v|
          v.ratings.sum(:score)
        end
        @violations.reverse!
    end
    @cities = City.order(name: :asc)
    if (params[:q].present? && params[:q][:city_id_eq].present?)
      city = City.find(params[:q][:city_id_eq].to_i)
      @districts = city.districts
    else
      @districts = @cities.find_by(name: "ADANA").districts
    end
    if (params[:q].present? && params[:q][:district_id_eq].present?)
      dist = District.find(params[:q][:district_id_eq].to_i)
      @neighborhoods = dist.neighborhoods
    else
      @neighborhoods = @districts.find_by(name: "ALADAĞ").neighborhoods
    end
  end

  # GET /violations/1
  # GET /violations/1.json
  def show
  end

  # GET /violations/new
  def new
    @violation = Violation.new
    @cities = City.order(name: :asc)
    @districts = @cities.find_by(name: "ADANA").districts
    @neighborhoods = @districts.find_by(name: "ALADAĞ").neighborhoods
    @types = Type.all
  end

  # GET /violations/1/edit
  def edit
    @cities = City.order(name: :asc)
    @districts = @cities.find_by(name: @violation.city.name).districts
    @neighborhoods = @districts.find_by(name: @violation.district.name).neighborhoods
    @types = Type.all
  end

  def districts
    @districts = City.find_by(id: params[:city_id]).districts

    response = @districts.to_json
    render json: response

  end

  def neighborhoods
    @neighborhoods = District.find_by(id: params[:district_id]).neighborhoods

    response = @neighborhoods.to_json
    render json: response
  end

  def type
    @type = Type.find_by(id: params[:type_id])

    render json: @type
  end

  def comment
    comment = Comment.new
    comment.user = current_user
    comment.description = params[:comment]
    
    @violation = Violation.find(params[:id])
    comment.violation = @violation
    if comment.save
      redirect_to @violation, notice: 'Comment was successfully created.'
    else
      redirect_to @violation, alert: 'Error!, comment was not created.'
    end
  end

  def rating
    @violation = Violation.find(params[:id])
    @rating = @violation.ratings.build(score: params[:score], user: current_user)

    if @rating.save
      redirect_to :back, notice: 'Rating was successfully added.'
    else
      redirect_to :back, notice: 'You have already rated.'
    end
  end

  def picture_upload
  @picture = Picture.find(params[:picture_id])
    respondto do |format|
      if @picture.update(cardparams)
      format.js { render json: {photo: true} }
      else
        format.js { render json: @card.errors }
      end
    end
  end


  # POST /violations
  # POST /violations.json
  def create
    @violation = current_user.violations.build(violation_params)

    respond_to do |format|
      if @violation.save
        format.html { redirect_to @violation, notice: 'Violation was successfully created.' }
        format.json { render :show, status: :created, location: @violation }
      else
        format.html { render :new }
        format.json { render json: @violation.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /violations/1
  # PATCH/PUT /violations/1.json
  def update
    @cities = City.order(name: :asc)
    @districts = @cities.find_by(name: "ADANA").districts
    @neighborhoods = @districts.find_by(name: "ALADAĞ").neighborhoods
    @types = Type.all
    respond_to do |format|
      if @violation.update(violation_params)
        format.html { redirect_to @violation, notice: 'Violation was successfully updated.' }
        format.json { render :show, status: :ok, location: @violation }
      else
        format.html { render :edit }
        format.json { render json: @violation.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /violations/1
  # DELETE /violations/1.json
  def destroy
    @violation.destroy
    respond_to do |format|
      format.html { redirect_to violations_url, notice: 'Violation was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_violation
      @violation = Violation.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def violation_params
      if (!params[:image_url].nil? )
        params[:image_url].gsub!(/{:value=>\"(.*)\"}/,"\\1")
      end
      params.permit(:title, :description, :city_id, :district_id, :neighborhood_id, :type_id, :address, :image_url, :tag_list, :closed)
    end

    def find_all_tag_list
      @all_tag_list = Violation.tag_counts_on(:tags).collect(&:name).uniq
    end

    def check_user_authentication
      unless @violation.user == current_user
        redirect_to violations_path
      end
    end
end
