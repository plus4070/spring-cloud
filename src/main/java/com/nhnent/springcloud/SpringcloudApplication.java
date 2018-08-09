package com.nhnent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class SpringcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApplication.class, args);
	}
}

@Entity
class Cat {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    Cat() {}

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" + "id=" + id + ", name=" + '\'' + '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> {
}