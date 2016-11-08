//
//  SimpleItemObject.h
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface SimpleItemObject : NSObject

@property (nonatomic, retain) NSString *labelText;
@property (nonatomic, retain) NSString *urlText;


- (instancetype)initWithProperties:(NSString*) labelText withUrl:(NSString*) url;

@end
typedef NSMutableArray<SimpleItemObject *> BooksData;
