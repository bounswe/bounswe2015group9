class Rating < ActiveRecord::Base
  belongs_to :violation
  belongs_to :user

  validate :score, inclusion: { in: %w(1 -1),
    message: "%{value} is not a valid score" }
end
