class Violation < ActiveRecord::Base
  acts_as_taggable
  belongs_to :user
  belongs_to :city
  belongs_to :district
  belongs_to :neighborhood
  belongs_to :type

  has_many :ratings, dependent: :delete_all
  has_many :comments, dependent: :delete_all

  validates :title, :description, :address, :type, :city, :district, :neighborhood, presence: true
end
