class Violation < ActiveRecord::Base
  belongs_to :user

  validates :title, :description, :address, presence: true
end
