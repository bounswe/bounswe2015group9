class Violation < ActiveRecord::Base
  acts_as_taggable

  belongs_to :user
  has_many :ratings
  has_many :comments

  validates :title, :description, :address, presence: true
end
