package edu.metrostate.ics342.mediatracker.data.model

import android.R
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val email: String,
    val password: String,
    val username: String,
    val displayName: String,
    val clientId: String,
    val clientSecret: String
)

@Serializable
data class TokenRequest(
    val grantType: String,
    val email: String? = null,
    val password: String? = null,
    val refreshToken: String? = null,
    val clientId: String,
    val clientSecret: String
)

@Serializable
data class CreateAccount(
    val id: int,
    val email: String,
    val username: String,
    val displayName: String,
    val bio: String,
    val avatarURL: String,
    val followerCount: int,
    val followingCount: int,
    val trackedCount: int,
    val isFollowing: boolean,
    val createdAt: int,
)