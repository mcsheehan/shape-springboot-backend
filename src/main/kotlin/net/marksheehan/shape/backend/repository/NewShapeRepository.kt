package net.marksheehan.shape.backend.repository

import net.marksheehan.shape.backend.datamodel.Square
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NewShapeRepository : JpaRepository<Square, String> {

}