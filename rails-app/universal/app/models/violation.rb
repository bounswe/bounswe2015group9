class Violation < ActiveRecord::Base
  acts_as_taggable

  belongs_to :user
  belongs_to :city
  belongs_to :district
  belongs_to :neighborhood

  has_many :ratings
  has_many :comments

  validates :title, :description, :address, presence: true
end
