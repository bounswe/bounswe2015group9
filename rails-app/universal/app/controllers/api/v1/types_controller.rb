class Api::V1::TypesController < Api::V1::BaseController
  def index
    @types = Type.all

    render json: @types
  end
end
