class ViolationsController < ApplicationController
  before_action :set_violation, only: [:show, :edit, :update, :destroy]
  skip_before_filter :verify_authenticity_token, only: [:districts, :neighborhoods, :type]
  before_action :find_all_tag_list, only: [:new, :edit]

  # GET /violations
  # GET /violations.json
  def index
    @violations = Violation.all
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

  def districts
    @districts = City.find_by(id: params[:city_id]).districts

    render json: @districts
  end

  def neighborhoods
    @neighborhoods = District.find_by(id: params[:district_id]).neighborhoods

    render json: @neighborhoods
  end

  def type
    @type = Type.find_by(id: params[:type_id])

    render json: @type
  end

  def new_comment
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
  # GET /violations/1/edit
  def edit
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
      params.permit(:title, :description, :city_id, :district_id, :neighborhood_id, :type_id, :address, :image_url, :tag_list)
    end

    def find_all_tag_list
      @all_tag_list = Violation.tag_counts_on(:tags).collect(&:name).uniq
    end
end
