/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.infinispan.persistencestrategy.table.externalizer.impl;

import java.util.Arrays;

import org.hibernate.ogm.model.key.spi.AssociationKey;

/**
 * Identifies an association stored in Infinispan when using the "per table" strategy.
 *
 * @author Gunnar Morling
 */
public class PersistentAssociationKey {

	private final String[] columnNames;
	private final Object[] columnValues;

	public PersistentAssociationKey(String[] columnNames, Object[] columnValues) {
		this.columnNames = columnNames;
		this.columnValues = columnValues;
	}

	public static PersistentAssociationKey fromAssociationKey(AssociationKey key) {
		return new PersistentAssociationKey( key.getColumnNames(), key.getColumnValues() );
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public Object[] getColumnValues() {
		return columnValues;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode( columnNames );
		result = prime * result + Arrays.hashCode( columnValues );
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( getClass() != obj.getClass() ) {
			return false;
		}
		PersistentAssociationKey other = (PersistentAssociationKey) obj;
		if ( !Arrays.equals( columnNames, other.columnNames ) ) {
			return false;
		}
		if ( !Arrays.equals( columnValues, other.columnValues ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PersistentAssociationKey [columnNames=" + Arrays.toString( columnNames ) + ", columnValues=" + Arrays.toString( columnValues ) + "]";
	}
}
