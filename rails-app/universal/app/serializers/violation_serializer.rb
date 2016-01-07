class ViolationSerializer < ActiveModel::Serializer
  attributes :id, :title, :description, :closed, :image_url, :created_at, :tag_list

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
end