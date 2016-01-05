class Api::V1::UsersController < Api::V1::BaseController
  def me
    render json: current_user
  end

  def edit
    if current_user.update_attributes(user_params)
      render json: current_user
    else
      render json: current_user.errors, status: :unprocessable_entity
    end
  end

  def user_params
    params.require(:user).permit(:email, :password, :first_name, :last_name, :age)
  end
end
