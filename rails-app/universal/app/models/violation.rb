class Violation < ActiveRecord::Base
  acts_as_taggable

  belongs_to :user

  validates :title, :description, :address, presence: true
end
