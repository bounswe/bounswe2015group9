class HomeController < ApplicationController
  def index
	@violations = Violation.all.order(title: :desc)
  end
end
