class AddAttachmentPictureToViolations < ActiveRecord::Migration
  def self.up
    change_table :violations do |t|
      t.attachment :picture
    end
  end

  def self.down
    remove_attachment :violations, :picture
  end
end
