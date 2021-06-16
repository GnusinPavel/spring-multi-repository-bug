package org.example.general.dao

import org.example.general.entity.*
import org.springframework.data.jpa.repository.*
import org.springframework.stereotype.*

@Repository
interface MyEntityRepository : JpaRepository<MyEntity, Long> {
}