package com.example.demo.system

import javax.persistence.*
import com.fasterxml.jackson.annotation.*

@Entity
@Table(name = "testTablePerson")
data class Product(
    @JsonProperty("first_Name")
    @Column(name = "name", length = 50)
    val name:String="",

    @JsonProperty("last_Name")
    @Column(name="surname", length = 50)
    val surname:String="",

    @Id
    @JsonProperty("id")
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id:Long=0L
)