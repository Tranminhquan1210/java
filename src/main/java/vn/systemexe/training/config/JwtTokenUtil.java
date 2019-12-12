package vn.systemexe.training.config;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -5146467393743194646L;

	@Value("${app.jwt.secret}")
	private String SIGNING_KEY;

	@Value("${app.jwt.expiration}")
	private int ACCESS_TOKEN_VALIDITY_SECONDS;

	public static final String AUTHORITIES_KEY = "authorities";

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
	}

	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

//	public String generateToken(User user) {
//		return doGenerateToken(user);
//	}
//
//	private String doGenerateToken(User user) {
//		Claims claims = Jwts.claims().setSubject(user.getUsername());
//		if (user.getRoles() != null) {
//			final List<String> authorities = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
//			claims.put(AUTHORITIES_KEY, authorities);
//		} else {
//			claims.put(AUTHORITIES_KEY, new ArrayList<String>());
//		}
//
//		return Jwts.builder()
//				.setClaims(claims)
//				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS))
//				.compact();
//	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	

}