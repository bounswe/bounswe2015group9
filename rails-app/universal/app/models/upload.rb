class Upload < ActiveRecord::Base
  attr_accessor :store_path

  has_attached_file :upload, :path => "/image/:id/:filename"


  include Rails.application.routes.url_helpers

  validates_attachment :upload, content_type: { content_type: ["image/jpg", "image/jpeg", "image/png"] }

  def to_jq_upload
    {
      "name" => read_attribute(:upload_file_name),
      "size" => read_attribute(:upload_file_size),
      "url" => upload.url(:original),
      "delete_url" => upload_path(self),
      "delete_type" => "DELETE" 
    }
  end

  def get_path
    @store_path = "/uploads/images/#{SecureRandom.hex(32)}"
  end

end
