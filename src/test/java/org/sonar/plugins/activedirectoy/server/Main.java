/*
 * SonarQube Active Directory Plugin
 * Copyright (C) 2016-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.activedirectoy.server;

/**
 * Settings for Sonar:
 * <pre>
 * sonar.security.realm: ACTIVE_DIRECTORY
 * ldap.url: ldap://localhost:1024
 * ldap.baseDn: dc=example,dc=org
 * ldap.group.baseDn: dc=example,dc=org
 * </pre>
 */
public class Main {

  public static void main(String[] args) throws Exception {
    ApacheDS server = ApacheDS.start("example.org", "dc=example,dc=org");
    String resourceFile = "\"/static-groups.example.org.ldif\"";
    // String resourceFile = "\"/users.infosupport.com.ldif\"";
    server.importLdif(Main.class.getResourceAsStream(resourceFile));
    System.out.println(server.getUrl());
  }

}