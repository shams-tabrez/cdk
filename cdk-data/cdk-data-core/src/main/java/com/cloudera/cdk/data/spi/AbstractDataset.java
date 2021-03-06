/*
 * Copyright 2013 Cloudera.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.cdk.data.spi;

import com.cloudera.cdk.data.Dataset;
import com.cloudera.cdk.data.DatasetReader;
import com.cloudera.cdk.data.DatasetWriter;
import com.cloudera.cdk.data.View;
import javax.annotation.concurrent.Immutable;

/**
 * A common Dataset base class to simplify implementations.
 *
 * @param <E> The type of entities stored in this {@code Dataset}.
 * @since 0.9.0
 */
@Immutable
public abstract class AbstractDataset<E> implements Dataset<E>, RangeView<E> {

  @Override
  public Dataset<E> getDataset() {
    return this;
  }

  @Override
  public boolean deleteAll() {
    throw new UnsupportedOperationException(
        "This Dataset does not support deletion");
  }

  @Override
  @Deprecated
  public DatasetReader<E> getReader() {
    return newReader();
  }

  @Override
  @Deprecated
  public DatasetWriter<E> getWriter() {
    return newWriter();
  }

  @Override
  public boolean contains(E key) {
    // A Dataset contains all PartitionKeys, only sub-views have to check
    return true;
  }

  @Override
  public boolean contains(Marker marker) {
    // A Dataset contains all PartitionKeys contained by any Marker
    return true;
  }

  @Override
  public AbstractRangeView<E> from(Marker start) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public AbstractRangeView<E> fromAfter(Marker start) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public AbstractRangeView<E> to(Marker end) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public AbstractRangeView<E> toBefore(Marker end) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public AbstractRangeView<E> of(Marker partial) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Iterable<View<E>> getCoveringPartitions() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
