package uth.edu.backend.security;

import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class CustomSecurityContextSerializer implements Serializer<SecurityContext>, Deserializer<SecurityContext> {

    @Override
    public void serialize(SecurityContext securityContext, OutputStream outputStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(securityContext);
        oos.flush();
    }

    @Override
    public SecurityContext deserialize(InputStream inputStream) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        try {
            return (SecurityContext) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Failed to deserialize SecurityContext", e);
        }
    }
}