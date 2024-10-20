package com.recykal.Specifications.specification;

import com.recykal.Specifications.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public  static Specification<User> hasName(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),name));
    }

    public static Specification<User> hasEmail(String email){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"),email));
    }

    public  static  Specification<User> hasRole(String role){
        return ((root, query, criteriaBuilder) ->criteriaBuilder.equal(root.get("role"),role));
    }
}
