class Api::V1::BaseController < ApplicationController
  protect_from_forgery with: :null_session

  def current_user
    @current_user = doorkeeper_token && User.find(doorkeeper_token.resource_owner_id)
  end
end
