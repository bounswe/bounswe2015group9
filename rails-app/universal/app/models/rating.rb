class Rating < ActiveRecord::Base
  belongs_to :violation
  belongs_to :user

  before_validation :check_duplication

  validates :score, inclusion: { in: [1, -1],
    message: "%{value} is not a valid score" }

  private
    def check_duplication
      if Rating.where(violation: self.violation, user: self.user).present?
        false
      else
        true
      end
    end
end
