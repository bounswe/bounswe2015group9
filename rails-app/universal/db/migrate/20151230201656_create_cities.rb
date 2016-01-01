class CreateCities < ActiveRecord::Migration
  def change
    create_table :cities do |t|
      t.references :violation, index: true, foreign_key: true
      t.string :name

      t.timestamps null: false
    end
  end
end
