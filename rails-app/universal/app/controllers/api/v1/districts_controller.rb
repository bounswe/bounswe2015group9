class Api::V1::DistrictsController < Api::V1::BaseController
  def index
    @districts = City.find(params[:id]).districts

    render json: @districts
  end
end
