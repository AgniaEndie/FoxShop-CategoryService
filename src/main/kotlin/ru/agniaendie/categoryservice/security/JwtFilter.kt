package ru.agniaendie.categoryservice.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import ru.agniaendie.categoryservice.exception.AuthorizationHeaderUndefinedException
import ru.agniaendie.categoryservice.service.JwtService

@Component
class JwtFilter(@Autowired val jwtService: JwtService) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        if (request.getHeader("Authorization").isNotEmpty()) {
            val token = request.getHeader(HttpHeaders.AUTHORIZATION).substringAfter("Bearer")
            if (jwtService.validateToken(token)) {
                val claims = jwtService.extractAllClaims(token)
                val authenticatedUser = UsernamePasswordAuthenticationToken(
                    claims["sub"],
                    claims["credentials"]
                )
                val ctx = SecurityContextHolder.getContext()
                ctx.authentication = authenticatedUser
                SecurityContextHolder.setContext(ctx)
                if (SecurityContextHolder.getContext().authentication == null) {
                    throw AuthorizationHeaderUndefinedException("Failed-F")
                }
            } else {
                throw AuthorizationHeaderUndefinedException("Failed-M")
            }
        } else {
            throw AuthorizationHeaderUndefinedException("Failed-U")
        }
        filterChain.doFilter(request, response)
    }
}