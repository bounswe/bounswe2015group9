class UsersController < ApplicationController
	def show
		@profile = User.find_by_id(params[:id])
	end
end
