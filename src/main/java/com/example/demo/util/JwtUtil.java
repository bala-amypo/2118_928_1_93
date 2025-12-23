import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Claims;

public boolean validateToken(String token, UserDetails userDetails) {
    String username = extractUsername(token);

    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}

private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
}

private Date extractExpiration(String token) {
    return extractAllClaims(token).getExpiration();
}

private Claims extractAllClaims(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
}
