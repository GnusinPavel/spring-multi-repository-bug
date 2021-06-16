package org.example.general.entity

import javax.persistence.*

@Entity
@Table(name = "my_table")
data class MyEntity(
    @Id
    @GeneratedValue
    val id: Long,

    @Column
    val name: String,
)
