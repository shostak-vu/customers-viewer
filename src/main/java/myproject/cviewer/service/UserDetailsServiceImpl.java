package myproject.cviewer.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import myproject.cviewer.config.UserRoleEnum;
import myproject.cviewer.dto.Admin;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminService adminService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Admin admin = adminService.getByEmail(email);
		
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
		
		UserDetails userDetails = new org.springframework.security.core.userdetails
			.User(admin.getEmail(), admin.getPassword(), roles);
		
		return userDetails;
	}

}
