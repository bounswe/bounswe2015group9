class Api::V1::ViolationsController < Api::V1::BaseController
  def index
    @q = Violation.ransack(params["q"])
    @violations = @q.result.includes(:city, :district, :neighborhood, :user)
    @violations = @violations.tagged_with(params[:tag_list]) if params[:tag_list].present?
    @cities = City.order(name: :asc)
    @districts = @cities.find_by(name: "ADANA").districts
    @neighborhoods = @districts.find_by(name: "ALADAĞ").neighborhoods

    render json: @violations
  end

  private

    def violation_params
      params.permit(:title, :description, :city_id, :district_id, :neighborhood_id, :type_id, :user_id, :address, :image_url, :tag_list)
    end
end