package com.sahandm96.dox.domain;

/**
 * Role 0 is User == costumer
 * Role 1 is BranchOwner == manger
 * Role 2 is BranchAdmin == Admin != manger
 * Role 3 is DeliveryGay
 */

public enum ERole {
    ROLE_COSTUMER,
    ROLE_MANAGER,
    ROLE_ADMIN_MOD,
    ROLE_ADMIN_ECO,
    ROLE_ADMIN_VER,
    ROLE_VERIFIED,
    ROLE_USER,
    ROLE_FAN,
    ROLE_TEAM,
    ROLE_CO,
}
