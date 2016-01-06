class Api::V1::NeighborhoodsController < Api::V1::BaseController
  def index
    @neighborhoods = District.find(params[:id]).neighborhoods

    render json: @neighborhoods
  end
end
