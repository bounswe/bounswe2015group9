class CreateViolations < ActiveRecord::Migration
  def change
    create_table :violations do |t|
      t.references :user, index: true, foreign_key: true
      t.string :title
      t.text :description
      t.boolean :closed
      t.text :address

      t.timestamps null: false
    end
  end
end
