class Api::V1::TagsController < Api::V1::BaseController
  def index
    @tags = ActsAsTaggableOn::Tag.all

    render json: @tags
  end
end
