class HomeController < ApplicationController
  def index
	@violations = Violation.all.order(created_at: :desc)
  end
end
