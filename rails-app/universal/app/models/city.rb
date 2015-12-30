class City < ActiveRecord::Base
  has_many :districts
  has_many :violations

  validates :name, presence: true
end
