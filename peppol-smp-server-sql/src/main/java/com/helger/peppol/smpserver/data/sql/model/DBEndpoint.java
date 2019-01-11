/**
 * Copyright (C) 2015-2019 Philip Helger and contributors
 * philip[at]helger[dot]com
 *
 * The Original Code is Copyright The PEPPOL project (http://www.peppol.eu)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.helger.peppol.smpserver.data.sql.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;

import com.helger.db.jpa.annotation.UsedOnlyByJPA;
import com.helger.db.jpa.eclipselink.converter.JPALocalDateTimeConverter;
import com.helger.peppol.smp.ExtensionType;
import com.helger.peppol.smp.SMPExtensionConverter;

/**
 * Endpoint generated by hbm2java
 *
 * @author PEPPOL.AT, BRZ, Philip Helger
 */
@Entity
@Table (name = "smp_endpoint")
@Converter (name = "localdatetime", converterClass = JPALocalDateTimeConverter.class)
public class DBEndpoint implements Serializable
{
  private DBEndpointID m_aID;
  private DBProcess m_aProcess;
  private String m_sEndpointReference;
  private boolean m_bRequireBusinessLevelSignature;
  private String m_sMinimumAuthenticationLevel;
  private LocalDateTime m_aServiceActivationDate;
  private LocalDateTime m_aServiceExpirationDate;
  private String m_sCertificate;
  private String m_sServiceDescription;
  private String m_sTechnicalContactUrl;
  private String m_sTechnicalInformationUrl;
  private String m_sExtension;

  @Deprecated
  @UsedOnlyByJPA
  public DBEndpoint ()
  {}

  public DBEndpoint (final DBEndpointID aID,
                     final DBProcess aProcess,
                     final String sEndpointReference,
                     final boolean bRequireBusinessLevelSignature,
                     final String sMinimumAuthenticationLevel,
                     final LocalDateTime aServiceActivationDate,
                     final LocalDateTime aServiceExpirationDate,
                     final String sCertificate,
                     final String sServiceDescription,
                     final String sTechnicalContactUrl,
                     final String sTechnicalInformationUrl,
                     final String sExtension)
  {
    m_aID = aID;
    m_aProcess = aProcess;
    m_sEndpointReference = sEndpointReference;
    m_bRequireBusinessLevelSignature = bRequireBusinessLevelSignature;
    m_sMinimumAuthenticationLevel = sMinimumAuthenticationLevel;
    m_aServiceActivationDate = aServiceActivationDate;
    m_aServiceExpirationDate = aServiceExpirationDate;
    m_sCertificate = sCertificate;
    m_sServiceDescription = sServiceDescription;
    m_sTechnicalContactUrl = sTechnicalContactUrl;
    m_sTechnicalInformationUrl = sTechnicalInformationUrl;
    m_sExtension = sExtension;
  }

  @EmbeddedId
  public DBEndpointID getId ()
  {
    return m_aID;
  }

  @Deprecated
  @UsedOnlyByJPA
  public void setId (final DBEndpointID aID)
  {
    m_aID = aID;
  }

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumns ({ @JoinColumn (name = "processIdentifier",
                               referencedColumnName = "processIdentifier",
                               nullable = false,
                               insertable = false,
                               updatable = false),
                  @JoinColumn (name = "processIdentifierType",
                               referencedColumnName = "processIdentifierType",
                               nullable = false,
                               insertable = false,
                               updatable = false),
                  @JoinColumn (name = "businessIdentifier",
                               referencedColumnName = "businessIdentifier",
                               nullable = false,
                               insertable = false,
                               updatable = false),
                  @JoinColumn (name = "businessIdentifierScheme",
                               referencedColumnName = "businessIdentifierScheme",
                               nullable = false,
                               insertable = false,
                               updatable = false),
                  @JoinColumn (name = "documentIdentifier",
                               referencedColumnName = "documentIdentifier",
                               nullable = false,
                               insertable = false,
                               updatable = false),
                  @JoinColumn (name = "documentIdentifierScheme",
                               referencedColumnName = "documentIdentifierScheme",
                               nullable = false,
                               insertable = false,
                               updatable = false) })
  public DBProcess getProcess ()
  {
    return m_aProcess;
  }

  public void setProcess (final DBProcess aProcess)
  {
    m_aProcess = aProcess;
  }

  @Lob
  @Column (name = "extension", length = 65535)
  public String getExtension ()
  {
    return m_sExtension;
  }

  public void setExtension (@Nullable final String sExtension)
  {
    m_sExtension = sExtension;
  }

  @Transient
  public void setExtension (@Nullable final ExtensionType aExtension)
  {
    setExtension (SMPExtensionConverter.convertToString (aExtension));
  }

  @Column (name = "endpointReference", nullable = false, length = 256)
  public String getEndpointReference ()
  {
    return m_sEndpointReference;
  }

  public void setEndpointReference (final String sEndpointReference)
  {
    m_sEndpointReference = sEndpointReference;
  }

  @Column (name = "requireBusinessLevelSignature", nullable = false)
  public boolean isRequireBusinessLevelSignature ()
  {
    return m_bRequireBusinessLevelSignature;
  }

  public void setRequireBusinessLevelSignature (final boolean bRequireBusinessLevelSignature)
  {
    m_bRequireBusinessLevelSignature = bRequireBusinessLevelSignature;
  }

  @Column (name = "minimumAuthenticationLevel", length = 256)
  public String getMinimumAuthenticationLevel ()
  {
    return m_sMinimumAuthenticationLevel;
  }

  public void setMinimumAuthenticationLevel (final String sMinimumAuthenticationLevel)
  {
    m_sMinimumAuthenticationLevel = sMinimumAuthenticationLevel;
  }

  @Column (name = "serviceActivationDate", length = 19)
  @Convert ("localdatetime")
  public LocalDateTime getServiceActivationDate ()
  {
    return m_aServiceActivationDate;
  }

  public void setServiceActivationDate (final LocalDateTime aServiceActivationDate)
  {
    m_aServiceActivationDate = aServiceActivationDate;
  }

  @Column (name = "serviceExpirationDate", length = 19)
  @Convert ("localdatetime")
  public LocalDateTime getServiceExpirationDate ()
  {
    return m_aServiceExpirationDate;
  }

  public void setServiceExpirationDate (final LocalDateTime aServiceExpirationDate)
  {
    m_aServiceExpirationDate = aServiceExpirationDate;
  }

  @Lob
  @Column (name = "certificate", nullable = false, length = 65535)
  public String getCertificate ()
  {
    return m_sCertificate;
  }

  public void setCertificate (final String sCertificate)
  {
    m_sCertificate = sCertificate;
  }

  @Lob
  @Column (name = "serviceDescription", nullable = false, length = 65535)
  public String getServiceDescription ()
  {
    return m_sServiceDescription;
  }

  public void setServiceDescription (final String sServiceDescription)
  {
    m_sServiceDescription = sServiceDescription;
  }

  @Column (name = "technicalContactUrl", nullable = false, length = 256)
  public String getTechnicalContactUrl ()
  {
    return m_sTechnicalContactUrl;
  }

  public void setTechnicalContactUrl (final String sTechnicalContactUrl)
  {
    m_sTechnicalContactUrl = sTechnicalContactUrl;
  }

  @Column (name = "technicalInformationUrl", length = 256)
  public String getTechnicalInformationUrl ()
  {
    return m_sTechnicalInformationUrl;
  }

  public void setTechnicalInformationUrl (final String sTechnicalInformationUrl)
  {
    m_sTechnicalInformationUrl = sTechnicalInformationUrl;
  }
}
