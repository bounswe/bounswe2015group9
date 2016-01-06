class Neighborhood < ActiveRecord::Base
  belongs_to :district
  has_many :violations

  validates :name, presence: true
end
