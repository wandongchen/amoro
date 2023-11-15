/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netease.arctic.server.table.internal;

import com.netease.arctic.server.table.TableMetadata;

import java.io.Closeable;

/** Interface to create an internal table. */
public interface InternalTableCreator extends Closeable {

  /**
   * Do all things about create an internal table, and prepare the {@link TableMetadata} for {@link
   * com.netease.arctic.server.table.TableService#createTable(java.lang.String,
   * com.netease.arctic.server.table.TableMetadata)}
   */
  TableMetadata create();

  /** Rollback all resource created during {@link #create()} */
  void rollback();

  /** Release resource like {@link org.apache.iceberg.io.FileIO} */
  @Override
  default void close() {}
}