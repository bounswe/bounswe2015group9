class District < ActiveRecord::Base
  belongs_to :city
  has_many :violations
  has_many :neighborhoods

  validates :name, presence: true
end
