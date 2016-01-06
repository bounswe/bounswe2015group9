class Rating < ActiveRecord::Base
  belongs_to :violation
  belongs_to :user

  validates :score, inclusion: { in: [1, -1],
    message: "%{value} is not a valid score" }
end
