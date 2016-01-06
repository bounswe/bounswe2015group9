class Api::V1::RegistrationsController < Api::V1::BaseController
  skip_before_filter :verify_authenticity_token
  respond_to :json

  def create

    user = User.new(user_params)

    if user.save
      access_token = Doorkeeper::AccessToken.find_by(resource_owner_id: user.id)
      render :json => user.as_json(:auth_token=> access_token, :email=>user.email), :status=>201
      return
    else
      warden.custom_failure!
      render :json => user.errors, :status=>422
    end
  end

  def user_params
    params.permit(:email, :password, :first_name, :last_name, :age, :gender)
  end

end