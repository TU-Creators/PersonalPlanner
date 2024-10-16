package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.service.model.PPUser
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service


@Service
class SecurityService {

    private fun extractClaim(): Map<String, Any> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val principal: Any = authentication.principal
        val claims: Map<String, Any> = (principal as Jwt).claims
        return claims
    }

    fun getCurrentUser(): PPUser {
        val claims = extractClaim()
        return PPUser(
            claims["sub"] as String,
            claims["name"] as String,
            claims["email"] as String,
        )
    }

}