package com.example.demo.service

import com.example.demo.system.*
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.springframework.stereotype.Service
import org.yaml.snakeyaml.events.Event.ID
import javax.persistence.Id

@Service
class ProductService(private val productRepository: ProductRepository)
{
    fun all(): Iterable<Product> = productRepository.findAll()

    fun get(id: Long):Product=productRepository.findById(id)

    fun add(product: Product): Product = productRepository.save(product)

    fun edit(id: Long, product: Product): Product = productRepository.save(product.copy(id = id))

    fun remove(id: Long) = productRepository.delete(id)
}