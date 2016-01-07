class ViolationDetailSerializer < ActiveModel::Serializer
  attributes :id, :title, :description, :image_url, :closed, :created_at, :address, :tag_list

  def attributes
  	data = super
  	if object.ratings.nil?
  		data[:rating] = object.ratings.sum(:score)
  	else
  		data[:rating] = 0
  	end
  	data
  end
  has_one :user
  has_one :type
  has_one :city
  has_one :district
  has_one :neighborhood
  has_many :comments
end