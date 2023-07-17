package com.example.demo.service

import com.example.demo.system.*
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.yaml.snakeyaml.events.Event.ID
import java.util.UUID
import javax.persistence.Id
import kotlin.jvm.optionals.toList

@Service
class ProductService(private val productRepository: ProductRepository)
{
    fun all(): Iterable<Product> = productRepository.findAll()

    fun get(id: Long):Product{

        val info=productRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw  RuntimeException("Не существует")
    }

    fun add(product: Product): Product
    {
        return productRepository.save(product)
    }

    fun edit(id: Long, product: Product): Product = productRepository.save(product.copy(id = id))

    fun remove(id: Product)
    {
         productRepository.delete(id)
    }
}