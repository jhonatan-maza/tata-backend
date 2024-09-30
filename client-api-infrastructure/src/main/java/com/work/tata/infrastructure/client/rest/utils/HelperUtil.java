package com.work.tata.infrastructure.client.rest.utils;

import com.work.tata.infrastructure.client.persistence.model.ERole;
import com.work.tata.infrastructure.client.persistence.model.RoleEntity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class HelperUtil {
    private HelperUtil() {
    }

    public static Supplier<List<RoleEntity>> roleSupplier = () ->
            Arrays.asList(
					RoleEntity.builder().id(1).name(ERole.valueOf("ROLE_USER")).build(),
                    RoleEntity.builder().id(1).name(ERole.valueOf("ROLE_MODERATOR")).build(),
                    RoleEntity.builder().id(1).name(ERole.valueOf("ROLE_ADMIN")).build()
            );

}
