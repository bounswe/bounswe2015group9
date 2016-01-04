class AddImageUrlToViolation < ActiveRecord::Migration
  def change
    add_column :violations, :image_url, :text
  end
end
