package com.managmentcampainapp.demo.entity;

import javax.persistence.*;
import java.lang.Long;

@Entity
public class Campaign {


        @Id
        @SequenceGenerator(name= "product_id_generator", initialValue = 10, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
        private Long id;


        private String name;

        private String town;

        public Campaign() {
        }

        public Campaign(Long id, String name, String town) {
                this.id = id;
                this.name = name;
                this.town = town;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getTown() {
                return town;
        }

        public void setTown(String town) {
                this.town = town;
        }
}
